package chap07

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE) // annotation의 처리 방법 - SOURCE: 컴파일 시간에 제거됨
@MustBeDocumented
annotation class Fancy