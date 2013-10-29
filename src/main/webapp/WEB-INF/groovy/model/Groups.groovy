package model

import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Groups {

	def list() {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from group
			where email == userEmail
			sort asc by name
  	}
	}

	def delete(id) {
		Key key = KeyFactory.createKey("group", Long.parseLong(id))
		key.delete()
	}

	def add(name, description) {
    def e = new Entity("group")
		e.email = memcache['userEmail']
    e.name = name
    e.description = description
    e.dateCreated = (new Clock()).getDateTime()
    e.save()	
	}

}
