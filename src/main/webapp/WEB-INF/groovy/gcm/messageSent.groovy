import groovy.json.*
import util.*
import model.*

def model = new Messages()
def e = model.get(params.id)
e.status = 'SENT'
e.dateSent = (new Clock()).getDateTime()
e.save()
