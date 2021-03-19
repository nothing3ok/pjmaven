package cn.pjwebserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * �������
 * �������ÿ��ʵ�����ڱ�ʾһ��http��������
 *
 * һ��http������������֣�
 * �����У���Ϣͷ����Ϣ����
 */
public class HttpRequest {
    /**
     * �����������Ϣ����
     */
    //����ʽ
    private String method;
    //������Դ�ĳ���·��
    private String url;
    //����ʹ�õ�httpЭ��汾
    private String protocol;

    /**
    ��Ϣͷ�����Ϣ����
     */

    /**
     * ��Ϣ���������Ϣ����
     */


    /**
     * �����������Ϣ����
     */
    private Socket socket;
    private InputStream in;
    /**
     * ���췽����������ʼ���������
     */
    public HttpRequest(Socket socket) {

        try {
            this.socket=socket;
            this.in=socket.getInputStream();
            /**
             * 1.����������
             * 2.������Ϣͷ
             * 3.������Ϣ����
             */
            parseRequestLine();
            parseHeaders();
            parseContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��Ϣ������
     */
    private void parseRequestLine(){
        System.out.println("httprequest:����������");
        try {
            //��ȡ������������
            StringBuilder builder=new StringBuilder();
            int c1=-1,c2=-1;
            while ((c2=in.read())!=-1){
                if (c1==13&&c2==10){
                    break;}
            }
            String line =builder.toString().trim();
            System.out.println("�����У�"+line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("�������");
    }

    /**
     * ������Ϣͷ
     */
    private void parseHeaders(){}

    /**
     * ������Ϣ����
     */
    private void parseContent(){}
}
