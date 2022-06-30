<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%> <%@ page session="false"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Home</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        <h1>!!!!!!DEPT TEST!!!!!!!</h1>

        <h3>1. 모든 Dept 정보</h3>
        <button onclick="getDepts()">확인</button>
        <br />
        <div id="depts"></div>
        <h3>2. Dept 추가</h3>
        <form action="#" name="inputForm" onsubmit="return insertDept()">
            <input
                type="text"
                name="deptno"
                placeholder="부서번호를 입력하세요"
            />
            <br />
            <input type="text" name="dname" placeholder="부서명을 입력하세요" />
            <br />
            <input type="text" name="loc" placeholder="근무지를 입력하세요" />
            <br />
            <input type="submit" value="추가" />
        </form>
        <div id="test"></div>

        <script>
            function getDepts() {
                document.getElementById("depts").innerHTML =
                    "<button onclick='closeDepts()'>닫기</button>" + "<br>";
                axios
                    .get("http://localhost:8080/jdbc/api/depts")
                    .then((response) => {
                        console.log(response.data);
                        for (let v of response.data) {
                            document.getElementById("depts").innerHTML +=
                                "deptno : " +
                                v.deptno +
                                " dname : " +
                                v.dname +
                                " loc : " +
                                v.loc +
                                "<br>";
                        }
                    });
            }

            function closeDepts() {
                document.getElementById("depts").innerHTML = null;
            }

            // (JSON) INSERT "/api/deptjson" => deptno : 90, dname : FRONTEND, loc : JEJU
            // var data = {
            //     deptno: 90,
            //     dname: "FRONTEND",
            //     loc: "JEJU",
            // };
            // axios
            //     .post("http://localhost:8080/jdbc/api/deptjson", data)
            //     .then((response) => {
            //         console.log(response.data);
            //     });

            // (FORMEncoded) INSERT "/api/deptjson" => deptno : 100, dname : TEST, loc : TEST

            function insertDept() {
                var inputValues = window.document.inputForm;
                console.log(inputValues.deptno.value);
                let deptno = inputValues.deptno.value;
                let dname = inputValues.dname.value;
                let loc = inputValues.loc.value;

                let form = new URLSearchParams();
                if (deptno != "" && dname != "" && loc != "") {
                    form.append("deptno", deptno);
                    form.append("dname", dname);
                    form.append("loc", loc);
                    //("deptno=100&dname=TEST&loc=TEST");
                    axios
                        .post("http://localhost:8080/jdbc/api/deptform", form)
                        .then((response) => {
                            if (response.status == 200) {
                                return true;
                            } else {
                                return false;
                            }
                        });
                } else {
                    alert("입력값을 확인해주세요!");
                }
            }
        </script>
    </body>
</html>
