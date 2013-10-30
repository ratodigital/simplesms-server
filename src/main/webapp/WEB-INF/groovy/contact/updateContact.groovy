import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  new Contacts().update(params.id, params.name, params.phone, params.groups)
  forward '/contact/listContact.groovy'
}




