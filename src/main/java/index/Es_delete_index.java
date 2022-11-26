package index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class Es_delete_index {
    public static void main(String[] args) throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",
                9200,"http")));
        //查询索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("user");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        //响应状态
        System.out.println(delete.isAcknowledged());
        //关闭ES客户端
        restHighLevelClient.close();
    }
}
