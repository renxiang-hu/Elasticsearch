package doc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

public class Es_doc_insert {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",
                9200, "http")));
        //插入数据
        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");

        User user = new User();
        user.setName("胡仁祥");
        user.setAge(30);
        user.setSex("男");

        //向Es插入数据，必须将数据转化成JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        request.source(userJson, XContentType.JSON);

        IndexResponse index = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(index);
        esClient.close();
    }
}
