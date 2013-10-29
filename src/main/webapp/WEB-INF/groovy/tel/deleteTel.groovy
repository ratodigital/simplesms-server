import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Phones()
  model.delete(params.id)

  forward '/tel/listTel.groovy'
}
