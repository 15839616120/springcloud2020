package guifan.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
    private String msg;
    private int code;
    private T data;


  public ResultBean() {
    super();

  }

  /**
   * 该方法应该为主流方法，异常码统一在BusinessEnum枚举中添加
   * @param businessEnum
   */
  public ResultBean(BusinessEnum businessEnum) {
    super();
    this.code = businessEnum.getCode();
    this.msg = businessEnum.getMsg();
  }

  public ResultBean(BusinessEnum businessEnum, T data) {
    super();
    this.code = businessEnum.getCode();
    this.msg = businessEnum.getMsg();
    this.data = data;
  }

  private ResultBean(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}