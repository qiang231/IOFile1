package proxy;
//��̬����ģʽ
//�ӿ�
interface ClothFactory{
    void productCloth();
}

//��������
class NikeClothFactory implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike���������·�");
    }
}

//������
class ProxyFactory implements ClothFactory{

    ClothFactory cf;
    public ProxyFactory(ClothFactory cf){
        this.cf = cf;
    }
    @Override
    public void productCloth() {
        System.out.println("�����࿪ʼִ�У��մ����");
        cf.productCloth();
    }
}
public class TestClothProduct {
    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();//������������Ķ���
        ProxyFactory proxy = new ProxyFactory(nike);   //����������Ķ���
        proxy.productCloth();

    }
}
