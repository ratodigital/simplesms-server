import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  def model = new Groups()
  model.delete(params.id)

  forward '/group/listGroup.groovy'
}
