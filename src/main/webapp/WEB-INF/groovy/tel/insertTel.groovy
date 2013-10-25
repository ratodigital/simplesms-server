import model.*

def model = new Phones()
model.add(params.number, params.name)

forward '/tel/listTel.groovy'
