package com.example.chat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

    public class Message {
        public String type;
        public String sender;
        public String content;
        public String recipient;

        public String filename;

        @JsonCreator
        public Message(@JsonProperty("type") String type,
                       @JsonProperty("sender") String sender,
                       @JsonProperty("content") String content,
                       @JsonProperty("recipient") String recipient,
                       @JsonProperty("filename")String filename) {
            this.type = type;
            this.sender = sender;
            this.content = content;
            this.recipient = recipient;
            this.filename= filename;
        }
        // 其他属性和方

    @Override
    public String toString(){
        return "{type='"+type+"', sender='"+sender+"', content='"+content+"', recipient='"+recipient+"',filename='" +filename+"'}";
    }
}
