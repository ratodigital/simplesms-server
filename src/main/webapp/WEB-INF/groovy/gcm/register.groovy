import groovy.json.*
import model.*

def user = null
def status = ""
def code = ""
def message = ""

if (!params.regId || !params.email || !params.password || !params.name) {
  status = "ERROR"
  code = "99"
  message = "INVALID PARAMETERS"  
} else {
	def userModel = new Users()
  user = userModel.getPassword(params.email)
  if (user != null && user.password != params.password) {
      status = "ERROR"
      code = "01"
      message = "INVALID PASSWORD"
  } else {
		def deviceModel = new Devices()
    device = deviceModel.getEmailByDeviceId(params.regId)

    if (device != null) {
      if (device.email != params.email) {
        status = "ERROR"
        code = "02"
        message = "DEVICE ALREADY REGISTERED FOR ANOTHER USER"
      } else {
        status = "ERROR"      
        code = "03"
        message = "DEVICE ALREADY REGISTERED FOR THIS USER"
      }
    } else {
      if (deviceModel.deviceNameExists(params.email, params.name)) {
        status = "ERROR"
        code = "04"
        message = "DEVICE NAME ALREADY EXISTS"
      }
    }
    
    if (status != "ERROR") {
		  if (user == null) {
				userModel.add(params.email, params.password)
		  }
			deviceModel.add(params.regId, params.name, params.email)
      code = "00"
      message = "DEVICE REGISTERED OK"
    }
  }
}


def json = new JsonBuilder([status:status, code: code, message: message])
println JsonOutput.prettyPrint(json.toString())
  
