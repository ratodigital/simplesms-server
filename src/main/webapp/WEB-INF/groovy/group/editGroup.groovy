import model.*

if (!memcache["userEmail"]) {
	redirect "/"
} else {
  
  request.group = params.id ? new Groups().get(params.id) : null
  
  forward '/WEB-INF/pages/group.gtpl'
}

