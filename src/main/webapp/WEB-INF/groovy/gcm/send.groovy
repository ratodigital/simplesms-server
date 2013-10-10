import util.*

def gcm = new GoogleGCM()
def result = gcm.send(params.regId, params.title, params.message)
if (result.success == 1) {
  println "FUNFOU!!!!"
} else {
  println "DEU $result.success BRAGA!! $result "
}
