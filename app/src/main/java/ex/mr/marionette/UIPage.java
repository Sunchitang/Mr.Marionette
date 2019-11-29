package ex.mr.marionette;

import java.io.Serializable;

public class UIPage implements Serializable {
    private Number head;
    private String itemTitle;
    private String itemSubTitle;

    public UIPage(Number head, String itemTitle, String itemSubTitle) {
        this.head = head;
        this.itemTitle = itemTitle;
        this.itemSubTitle = itemSubTitle;
    }

    public Number getHead() {
        return head;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemSubTitle() {
        return itemSubTitle;
    }

    public void setHead(Number head) {
        this.head = head;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemSubTitle(String itemSubTitle) {
        this.itemSubTitle = itemSubTitle;
    }


}
