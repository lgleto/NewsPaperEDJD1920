package ipca.examples.newspaper.entities

import org.json.JSONObject

open class BaseModel : JsonProtocol {

    var id      : String? = null
    var title   : String? = null

    constructor(jsonObject: JSONObject){
        id = if (jsonObject.has("id"))
            jsonObject.getString("id") else null
        title = if (jsonObject.has("title"))
            jsonObject.getString("title") else null
    }


    override fun toJson(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("id", id)
        jsonObject.put("title", title)
        return jsonObject
    }

}