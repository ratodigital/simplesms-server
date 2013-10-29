package model

import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.KeyFactory
import com.google.appengine.api.datastore.Key
import groovyx.gaelyk.GaelykBindings
import util.*

@GaelykBindings
public class Messages {

	def list() {
		def userEmail = memcache['userEmail']
		datastore.execute {
	  	select all
	 	 	from message
			where email == userEmail
			sort desc by dateCreated
  	}
	}
	
  def get(id) {
    def longId = Long.parseLong(id)
    Key key = KeyFactory.createKey("message", longId)
    def goal = datastore.get(key)
  }
  
	def delete(id) {
		Key key = KeyFactory.createKey("message", Long.parseLong(id))
		key.delete()
	}
	
	def add(regId, message, phones) {
    def e = new Entity("message")
    e.regId = regId
		e.email = memcache['userEmail']
    e.message = message
		e.phones = phones
    e.status = "WAIT" // SENT
    e.dateCreated = (new Clock()).getDateTime()
    e.save()	
	}
}
