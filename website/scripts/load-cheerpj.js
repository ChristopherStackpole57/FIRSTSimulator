/*(async function () {
    await cheerpjInit({version: 17});
    cheerpjCreateDisplay(800, 600);
    await cheerpjRunJar("/app/java-source/HelloWorld.jar");
})();*/

async function startJavaSim() {
    await cheerpjInit({version: 17});

    const javaLib = await cheerpjRunLibrary("/app/java-source/Demo.jar");

    const Demo = await javaLib.Demo;
    const demo = await new Demo();

    window.demo = demo;

    console.log(await demo.getMessage());
    console.log(await demo.add(1, 2));

    const unityFrame = document.getElementById("unity-frame");
    unityFrame.contentWindow.postMessage({
        type: "java-message",
        value: await demo.getMessage()
    }, "*");
}

startJavaSim();