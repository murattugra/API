package pojos;

public class DummyPojoDelete {


     /*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
    Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
    {
    "status": "success",
    "data": "2",
    "message": "Successfully! Record has been deleted"
    }
   */


    private String status;
    private int data;
    private String message;

    public DummyPojoDelete() {
    }

    public DummyPojoDelete(String status, Integer data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyPojoDelete{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
