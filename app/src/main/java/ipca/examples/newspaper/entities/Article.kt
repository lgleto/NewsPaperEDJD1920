package ipca.examples.newspaper.entities

import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class Article : BaseModel {

    var author      : String?    = null
    var description : String?    = null
    var publishedAt : Date?      = null
    var url         : String?    = null
    var urlToImage  : String?    = null
    var content     : String?    = null
    var source      : Source?    = null
    var category    : Category?  = null


    constructor(jsonObject: JSONObject) : super(jsonObject) {
        author      = jsonObject.getString("author"     )
        description = jsonObject.getString("description")
        publishedAt = string2date(jsonObject.getString("publishedAt"))
        url         = jsonObject.getString("url"        )
        urlToImage  = jsonObject.getString("urlToImage" )
        content     = jsonObject.getString("content"    )
        source      = Source(jsonObject.getJSONObject("source"))

    }

    fun string2date(strDate:String) : Date {
        var date = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        formatter.parse(strDate)?.let {
            return it
        }
        return date
    }

    fun date2string(date:Date):String{
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        return formatter.format(date)
    }



    override fun toJson(): JSONObject {
        val jsonObject = super.toJson()
        jsonObject.put("author"     , author     )
        jsonObject.put("description", description)
        jsonObject.put("publishedAt", date2string(publishedAt!!))
        jsonObject.put("url"        , url        )
        jsonObject.put("urlToImage" , urlToImage )
        jsonObject.put("content"    , content    )
        jsonObject.put("source"     , source?.toJson()     )
        jsonObject.put("category"   , category?.toJson()   )
        return jsonObject
    }

}