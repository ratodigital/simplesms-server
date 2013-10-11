import util.*

def gcm = new GoogleGCM()
def result = gcm.send(params.regId, params.title, params.message)
if (result.success == 1) {
  println "MESSAGE SENT TO $params.regId<hr>TITLE: $params.title<hr>MESSAGE:$params.message"
} else {
  println "ERROR $result"
}
