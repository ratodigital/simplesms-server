package util

import groovy.json.*

/*
codes       text  
NEW_MESSAGE <QTD DE MENSAGENS A SEREM ENVIADAS>  /messages/@regId

{
[
  message: "aqui vai o texto da mensagem"
  devices: [
    "557181069246","55716665544","12341234"
  ]
]
[
  message: "aqui vai o texto da mensagem"
  devices: [
    "557181069246","55716665544","12341234"
  ]
]
[
  message: "aqui vai o texto da mensagem"
  devices: [
    "557181069246","55716665544","12341234"
  ]
]
}
*/

public class GoogleGCM {
  private static final def GCM_URL = 'https://android.googleapis.com/gcm/send'
  private static final def API_KEY = 'AIzaSyAQqPsrqBJqwaZJzwgBnjJh5nYi6IMkdvs'

  def send(regId, msgCode, msgText) {
    def queryString = "{\"registration_ids\":[\"${regId}\"],\"data\":{\"msg\":\"${msgText}\"}}"

    def regIds = [regId]

    def jsonQueryString = new JsonBuilder() 
    jsonQueryString {
      registration_ids regIds
      data(
        code: msgCode,
        text: msgText,        
      )
    }
    
    def url = new URL(GCM_URL)     
    def connection = url.openConnection()     
    connection.setRequestMethod("POST")    
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("Authorization", "key=$API_KEY")
    connection.doOutput = true      
    def writer = new OutputStreamWriter(connection.outputStream)     
    writer.write(jsonQueryString.toString())     
    writer.flush()     
    writer.close()     
    connection.connect()      
    def result = connection.content.text
    connection.disconnect()

	  def slurper = new JsonSlurper()
	  def jsonResponse = slurper.parseText(result)
    return jsonResponse
  }
}
