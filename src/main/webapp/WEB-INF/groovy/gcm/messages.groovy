import groovy.json.*
import util.*
import model.*


def model = new Messages()
def e = model.get(params.id)

def messages = [
  [
    id: e.key.id,
    text: e.message,
    devices: e.phones.split(",")
  ],
]

e.status = 'GATEWAY'
e.dateGateway = (new Clock()).getDateTime()
e.save()

def json = new JsonBuilder(status:"OK", code:"00", message:"1", messages:messages)
println JsonOutput.prettyPrint(json.toString())  
