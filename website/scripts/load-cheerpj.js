const unityMessageBus = (() => {
    const listeners = new Set();

    return {
        addEventListener(listener) {
            if (typeof listener != "function") {
                throw new TypeError("Listener must be a function.");
            }

            listeners.add(listener);
        },

        removeEventListener(listener) {
            listeners.delet(listener);
        },

        dispatch(message) {
            for (const listener of listeners) {
                try {
                    listener(message);
                } catch (error) {
                    console.error("Unity message listener failed: ", error);
                }
            }
        }
    };
})();

function dispatchMessageToUnity(message) {
    console.log("[JavaScript]: Received Message from Java:", message)

    const unityFrame = document.getElementById("unity-frame");
    unityFrame.contentWindow.postMessage({
        type: "java-message",
        value: message
    }, "*");
}
unityMessageBus.addEventListener(dispatchMessageToUnity);

async function startJavaSim() {
    await cheerpjInit({
        version: 17,
        natives: {
            async Java_util_UnityMessageQueue_dispatchToJavaScript(
                lib,
                message
            ) {
                unityMessageBus.dispatch(message);
            }
        }
    });

    //await cheerpjRunMain("Project", "/app/java-source/Robot.jar");

    const javaLib = await cheerpjRunLibrary("/app/java-source/Robot.jar");
    
    const UnityMessageQueue = await javaLib.util.UnityMessageQueue;

    const Robot = await javaLib.Robot;
    const robot = await new Robot();
    await robot.runOpMode();
}

startJavaSim();