import model.*

def model = new Phones()
request.tels = model.list()

//println tels
forward '/WEB-INF/pages/tels.gtpl'

