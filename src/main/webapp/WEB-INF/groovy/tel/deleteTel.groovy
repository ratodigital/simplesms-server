import model.*

def model = new Phones()
model.delete(params.id)

forward '/tel/listTel.groovy'

