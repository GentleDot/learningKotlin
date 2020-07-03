package chap06;

public class KCustomerAccess {
    public static void main(String[] args) {
        // kotlin class의 companion object 접근
        System.out.println(KCustomer.LEVEL);
        KCustomer.login(); // @JvmStatic annotation 을 사용할 때 접근 방법
        KCustomer.Companion.login(); // 위와 동일한 결과로 annotation 없이 접근 방법
    }
}
