package by.tc.task04.socket.client.print;

import by.tc.task04.entity.Text;

public class TextPrinter {
    private Text text;

    public TextPrinter(Text _text){
        text = _text;
    }

    public void print(){
        System.out.println(text.getContent());
    }

    public void setText(Text _text) {
        this.text = _text;
    }
}
