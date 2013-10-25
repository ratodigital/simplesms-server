import groovy.json.*

def messages = [
  [
    text: "this is the first message",
    devices: [
      "+557181069246",
      "+557193880220"
    ]
  ],
  [
    text: "this is the second message",
    devices: [
      "+557199501716"
    ]
  ]
]

def json = new JsonBuilder(status:"OK", code:"00", message:"2", messages:messages)
println JsonOutput.prettyPrint(json.toString())
  
