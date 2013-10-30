import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  new Contacts().delete(params.id)

  forward '/contact/listContact.groovy'
}
