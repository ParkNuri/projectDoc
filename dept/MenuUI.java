package jdbc.department;

public class MenuUI{
    Scanner key = new Scanner(System.in);
    DeptDAO dao = new DeptDAOImpl();

    public void insertMenu() {
        System.out.println("*******부서등록********");
        System.out.print("아이디:");
        String id = key.next();
        System.out.print("제목:");
        String title = key.next();
        System.out.print("내용:");
        String content = key.next();

        // 여기에서 EmpDAO의 메소드를 호출하세요
        DeptDTO dept = new DeptDTO(id, title, content);
        int result = dao.insert(Dept);
    }

    public void updateMenu() {
        System.out.println("*******부서수정********");
        System.out.print("아이디:");
        String id = key.next();
        System.out.print("부서번호:");
        String deptno = key.next();
        // 여기에서 EmpDAO의 메소드를 호출하세요
        // dao.update(deptno, id);
    }

    public void deleteMenu() {
        System.out.println("*******부서삭제********");
        System.out.print("부서번호:");
        String deptno = key.next();
        // 여기에서 EmpDAO의 메소드를 호출하세요
    }

    public void selectMenu() {
        System.out.println("*******부서조회********");
        // 여기에서 EmpDAO의 메소드를 호출하세요 - 전체사원조회
        ArrayList<DeptDTO> Deptlist = dao.select();
        int size = Deptlist.size();
        for (int i = 0; i < size; i++) {
            DeptDTO Dept = Deptlist.get(i);
            System.out.println(dept.getDeptno() + "\t" + dept.getTitle() + "\t" + dept.getContent() + "\t"
                    + dept.getWriteDate() + "\t" + dept.getHit());
        }
    }

    public void readMenu() {
        System.out.println("*******부서상세보기********");
        System.out.print("부서 번호: ");
        int deptno = key.nextInt();
        DeptDTO Dept = dao.read(deptno);
        dao.updateHit(deptno);
        if (Dept == null) {
            System.out.println("해당 게시물이 존재하지 않습니다");
        } else {
            System.out.println(dept.getDeptno() + "\t" + dept.getTitle() + "\t" + dept.getContent() + "\t"
                    + dept.getWriteDate() + "\t" + dept.getHit());
        }
    }

    public void findByTitleMenu() {
        System.out.println("*******제목으로부서검색********");
        System.out.print("부서 제목: ");
        String title = key.next();
        ArrayList<DeptDTO> Deptlist = dao.findByTitle(title);
        int size = Deptlist.size();
        if (size == 0) {
            System.out.println("해당 게시물이 존재하지 않습니다");
        } else {
            for (int i = 0; i < size; i++) {
                DeptDTO Dept = Deptlist.get(i);
                System.out.println(dept.getDeptno() + "\t" + dept.getTitle() + "\t" + dept.getContent() + "\t"
                        + dept.getWriteDate() + "\t" + dept.getHit());
            }
        }
    }

}