import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    // ����
    public static ArrayList<User> addUser(){
        List<User> list = new ArrayList<User>();
        User u = new User();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input no: ");
        u.setNo(sc.nextLine());
        System.out.print("Input name: ");
        u.setName(sc.nextLine());
        System.out.print("Input add: ");
        u.setAdd(sc.nextLine());
        System.out.print("Input age: ");
        u.setAge(sc.nextInt());
        list.add(u);
        return (ArrayList<User>) list;
    }
    // �޸�
    public static void updateUser(String name, List<User> list){
        Scanner sc = new Scanner(System.in);
        boolean isExist = false;
        for(int i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).getName())){
                isExist = true;
                System.out.print("������ no: ");
                list.get(i).setNo(sc.nextLine());
                System.out.print("������name: ");
                list.get(i).setName(sc.nextLine());
                System.out.print("������add: ");
                list.get(i).setAdd(sc.nextLine());
                System.out.print("������age: ");
                list.get(i).setAge(sc.nextInt());
            }
        }
        if(isExist == false){
            System.out.println("�����ڸ��û�");
        }
    }
    // ����
    public static void findUser(String name, List<User> list){
        boolean isExist = false;
        for(int i = 0; i < list.size(); i++){
            if(name.equals(list.get(i).getName())){
                isExist = true;
                System.out.println("�û����: " + list.get(i).getNo()
                        + ". ����: " + list.get(i).getName()
                        + ". ��ַ: " + list.get(i).getAdd()
                        + ". ����: " + list.get(i).getAge());
            }
        }
        if(isExist == false){
            System.out.println("�����ڸ��û�");
        }
    }
    // ɾ��
    public static void delUser(String name, List<User> list) {
        boolean isExist = false;
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getName())) {
                isExist = true;
                list.remove(i);
                System.out.println("���û���ɾ��");
            }
        }
        if (isExist == false) {
            System.out.println("�����ڸ��û�");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<User> list = new ArrayList<User>();
        int i = 0;
        while(true){
            System.out.println("�������ѡ��: 1.����\t2.����\t3.�޸�\t4.ɾ��\t0.�˳�");
            i = sc.nextInt();
            switch (i) {
            case 1:
                list = addUser();
                break;
            case 2:
                System.out.print("����Ҫ���ҵ��û���: ");
                String name = sc.next();
                findUser(name, list);
                break;
            case 3:
                System.out.print("����Ҫ�޸ĵ��û���: ");
                String n = sc.next();
                updateUser(n, list);  
                break;
            case 4:
                System.out.print("����Ҫɾ�����û���: ");
                String na = sc.next();
                delUser(na, list);
                break;
            case 0:
                System.out.println("�������!");
                System.exit(0);
                break;
            }
        }
    }
}
