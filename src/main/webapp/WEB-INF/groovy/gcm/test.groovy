import groovyx.net.http.RESTClient

def client = new RESTClient()
def resp = client.post(uri: "http://localhost:8080/gcm/register")
println resp.status
println resp.contentType

