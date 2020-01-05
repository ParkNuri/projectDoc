package jdbc.department;

public interface DeptDAO{
    int insert(DeptDTO dept);   //부서 등록
    int update(DeptDTO dept);   //부서 정보 수정
    int delete(String deptno);  //부서 삭제
    DeptDTO getDeptInfo();  //부서 정보 조회
    ArrayList<DeptDTO> getDeptList();   //부서 목록 조회
    ArrayList<EmpDTO> getMemberList(String deptno); //부서원 조회
}