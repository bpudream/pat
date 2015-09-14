package PAT;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by David on 2015/9/13.
 */
public class B1041 {

    String id;
    int val;
    public B1041(String id, int val) {
        this.id = id;
        this.val = val;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        HashMap<Integer, B1041> maps = new HashMap<Integer, B1041>();
        for(int i = 0; i < len; i++) {
            String id = in.next();
            int key = in.nextInt();
            int val = in.nextInt();
            B1041 info = new B1041(id, val);
            maps.put(key, info);
        }

        int k = in.nextInt();
        for(int i = 0; i < k; i++) {
            int key = in.nextInt();
            B1041 m = maps.get(key);
            System.out.println(m.id + " " + m.val);
        }
    }
}


/*ÿ��PAT�����ڲμӿ���ʱ���ᱻ����������λ�ţ�һ�����Ի���λ��һ���ǿ�����λ��
��������£��������볡ʱ�ȵõ��Ի���λ���룬���������Ի�״̬��ϵͳ����ʾ�ÿ����Ŀ�����λ���룬����ʱ������Ҫ����������λ������
����Щ�����ٵ��ˣ��Ի��Ѿ�����������ֻ�������쵽���Ի���λ�����������㣬�Ӻ�̨������ǵĿ�����λ���롣

�����ʽ��

�����һ�и���һ��������N��<=1000�������N�У�ÿ�и���һ����������Ϣ����׼��֤�� �Ի���λ�� ������λ�š���
����׼��֤����14λ������ɣ���λ��1��N��š����뱣֤ÿ���˵�׼��֤�Ŷ���ͬ�������κ�ʱ�򶼲���������˷��䵽ͬһ����λ�ϡ�

������Ϣ֮�󣬸���һ��������M��<=N�������һ���и���M������ѯ���Ի���λ���룬�Կո�ָ���

�����ʽ��

��Ӧÿ����Ҫ��ѯ���Ի���λ���룬��һ���������Ӧ������׼��֤�źͿ�����λ���룬�м���1���ո�ָ���

����������
4
10120150912233 2 4
10120150912119 4 1
10120150912126 1 3
10120150912002 3 2
2
3 4
���������
10120150912002 2
10120150912119 1*/