package ipca.examples.newspaper.entities

import org.json.JSONObject

class Source : BaseModel {

    var name    : String? = null
    var image   : Int?    = null

    constructor(jsonObject: JSONObject) : super(jsonObject) {
        name = jsonObject.getString("name")
    }


    override fun toJson(): JSONObject {
        val jsonObject = super.toJson()
        jsonObject.put("name", name)
        jsonObject.put("image", image)
        return jsonObject
    }
}
