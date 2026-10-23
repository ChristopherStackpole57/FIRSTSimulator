using UnityEngine;

public class JavaBridge : MonoBehaviour
{
    public void ReceiveMessage(string message)
    {
        Debug.Log("Recevied from Java: " + message);
    }

    public void ReceiveNumber(int value)
    {
        Debug.Log("Received number: " + value);
    }
}
