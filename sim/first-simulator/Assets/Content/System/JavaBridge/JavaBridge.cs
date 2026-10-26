using UnityEngine;

public class JavaBridge : MonoBehaviour
{
    public void ReceiveMessage(string message)
    {
        Debug.Log("[Unity] Received Message at Unity Endpoint: " + message);
    }

    public void ReceiveNumber(int value)
    {
        Debug.Log("Received number: " + value);
    }
}
