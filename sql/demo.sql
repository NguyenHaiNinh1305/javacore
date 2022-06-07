/* I. CREATE TABLES */

-- faculty (Khoa trong tr??ng)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (M�n h?c)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- t?ng s? ti?t h?c
);

-- student (Sinh vi�n)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- gi?i t�nh
	birthday date not null,
	hometown nvarchar2(100) not null, -- qu� qu�n
	scholarship number, -- h?c b?ng
	faculty_id number not null constraint faculty_id references faculty(id) -- m� khoa
);

-- exam management (B?ng ?i?m)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- s? l?n thi (thi tr�n 1 l?n ???c g?i l� thi l?i) 
	mark number(4,2) not null -- ?i?m
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, n'C? s? d? li?u', 45);
insert into subject values (2, n'Tr� tu? nh�n t?o', 45);
insert into subject values (3, n'Truy?n tin', 45);
insert into subject values (4, n'?? h?a', 60);
insert into subject values (5, n'V?n ph?m', 45);


-- faculty
insert into faculty values (1, n'Anh - V?n');
insert into faculty values (2, n'Tin h?c');
insert into faculty values (3, n'Tri?t h?c');
insert into faculty values (4, n'V?t l�');


-- student
insert into student values (1, n'Nguy?n Th? H?i', n'N?', to_date('19900223', 'YYYYMMDD'), 'H� N?i', 130000, 2);
insert into student values (2, n'Tr?n V?n Ch�nh', n'Nam', to_date('19921224', 'YYYYMMDD'), 'B�nh ??nh', 150000, 4);
insert into student values (3, n'L� Thu Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, n'L� H?i Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, n'Tr?n Anh Tu?n', n'Nam', to_date('19901220', 'YYYYMMDD'), 'H� N?i', 180000, 1);
insert into student values (6, n'Tr?n Thanh Mai', n'N?', to_date('19910812', 'YYYYMMDD'), 'H?i Ph�ng', null, 3);
insert into student values (7, n'Tr?n Th? Thu Th?y', n'N?', to_date('19910102', 'YYYYMMDD'), 'H?i Ph�ng', 10000, 1);


-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 1, 2, 6);
insert into exam_management values (3, 1, 2, 2, 6);
insert into exam_management values (4, 1, 3, 1, 5);
insert into exam_management values (5, 2, 1, 1, 4.5);
insert into exam_management values (6, 2, 1, 2, 7);
insert into exam_management values (7, 2, 3, 1, 10);
insert into exam_management values (8, 2, 5, 1, 9);
insert into exam_management values (9, 3, 1, 1, 2);
insert into exam_management values (10, 3, 1, 2, 5);
insert into exam_management values (11, 3, 3, 1, 2.5);
insert into exam_management values (12, 3, 3, 2, 4);
insert into exam_management values (13, 4, 5, 2, 10);
insert into exam_management values (14, 5, 1, 1, 7);
insert into exam_management values (15, 5, 3, 1, 2.5);
insert into exam_management values (16, 5, 3, 2, 5);
insert into exam_management values (17, 6, 2, 1, 6);
insert into exam_management values (18, 6, 4, 1, 10);



/*================================================*/

/* III. QUERY */


 /********* A. BASIC QUERY *********/

-- 1. Li?t k� danh s�ch sinh vi�n s?p x?p theo th? t?:
--      a. id t?ng d?n
--      b. gi?i t�nh
--      c. ng�y sinh T?NG D?N v� h?c b?ng GI?M D?N

-- 1.a
Select * from student
order by student.id asc;

--1.b
Select * from student
order by student.gender asc;

--1.c
Select * from student
order by student.birthday ASC, student.scholarship DESC;

-- 2. M�n h?c c� t�n b?t ??u b?ng ch? 'T'

select * from subject
where subject.name like 'T%';

-- 3. Sinh vi�n c� ch? c�i cu?i c�ng trong t�n l� 'i'
select * from student
where student.name like '%i';


-- 4. Nh?ng khoa c� k� t? th? hai c?a t�n khoa c� ch?a ch? 'n'
select * from faculty
where faculty.name like '_n%';

-- 5. Sinh vi�n trong t�n c� t? 'Th?'
select * from student
where student.name like '%Th?%';


-- 6. Sinh vi�n c� k� t? ??u ti�n c?a t�n n?m trong kho?ng t? 'a' ??n 'm', s?p x?p theo h? t�n sinh vi�n
select * from student
where student.name like 'T%' 
order by student.name;

-- 7. Sinh vi�n c� h?c b?ng l?n h?n 100000, s?p x?p theo m� khoa gi?m d?n
select * from student
where student.scholarship > 100000
order by student.faculty_id DESC;

-- 8. Sinh vi�n c� h?c b?ng t? 150000 tr? l�n v� sinh ? H� N?i
select * from student
where student.scholarship > 150000 and hometown = 'H� N?i';

-- 9. Nh?ng sinh vi�n c� ng�y sinh t? ng�y 01/01/1991 ??n ng�y 05/06/1992
select * from student
where student.birthday between to_date('19910101', 'YYYYMMDD') and to_date('19920605', 'YYYYMMDD');


-- 10. Nh?ng sinh vi�n c� h?c b?ng t? 80000 ??n 150000

select * from student
where 80000<= student.scholarship and student.scholarship <= 100000;

-- 11. Nh?ng m�n h?c c� s? ti?t l?n h?n 30 v� nh? h?n 45

select * from subject
where 30 < subject.lesson_quantity and subject.lesson_quantity < 45;

-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho bi?t th�ng tin v? m?c h?c b?ng c?a c�c sinh vi�n, g?m: M� sinh vi�n, Gi?i t�nh, M� 
		-- khoa, M?c h?c b?ng. Trong ?�, m?c h?c b?ng s? hi?n th? l� �H?c b?ng cao� n?u gi� tr? 
		-- c?a h?c b?ng l?n h?n 500,000 v� ng??c l?i hi?n th? l� �M?c trung b�nh�.
        select student.id, student.gender, student.faculty_id, student.scholarship,
        case when student.scholarship >500000 then  'high'
        else  'medium'
        end sholarlevel
        from student;
		
-- 2. T�nh t?ng s? sinh vi�n c?a to�n tr??ng

select  count(*)  AS totalstundent from student;


-- 3. T�nh t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n?.

select student.gender, count(*) AS total from student
group by student.gender;

-- 4. T�nh t?ng s? sinh vi�n t?ng khoa
select student.faculty_id, count(*) AS total from student
group by student.faculty_id;


-- 5. T�nh t?ng s? sinh vi�n c?a t?ng m�n h?c

select  exam_management.subject_id, count(exam_management.student_id) AS totalstudent from exam_management
group by exam_management.subject_id;

-- 6. T�nh s? l??ng m�n h?c m� sinh vi�n ?� h?c
select  exam_management.student_id, count(exam_management.subject_id) AS total_learned_subject from exam_management
group by exam_management.student_id;
-- h?i l?i
-- 7. T?ng s? h?c b?ng c?a m?i khoa	
select student.faculty_id, count(student.scholarship) as total_scholarship from student
group by student.faculty_id;
-- 8. Cho bi?t h?c b?ng cao nh?t c?a m?i khoa
select student.faculty_id, max(student.scholarship) as max_scholarship from student
group by student.faculty_id;


-- 9. Cho bi?t t?ng s? sinh vi�n nam v� t?ng s? sinh vi�n n? c?a m?i khoa
select student.gender,student.faculty_id, count(*) AS total from student
group by student.gender, student.faculty_id;

-- 10. Cho bi?t s? l??ng sinh vi�n theo t?ng ?? tu?i
select extract(year from student.birthday) as year,  count(student.id) AS total from student
group by extract(year from student.birthday);

-- 11. Cho bi?t nh?ng n?i n�o c� �t nh?t 2 sinh vi�n ?ang theo h?c t?i tr??ng

select student.hometown, count(student.id) AS numbers from student
group by student.hometown
having count(student.id)>=2 ;

-- 12. Cho bi?t nh?ng sinh vi�n thi l?i �t nh?t 2 l?n

select exam_management.student_id, count(exam_management.number_of_exam_taking) as total_reexam from exam_management
where exam_management.number_of_exam_taking = 2
group by exam_management.student_id
having count(exam_management.number_of_exam_taking)>=2;

-- 13. Cho bi?t nh?ng sinh vi�n nam c� ?i?m trung b�nh l?n 1 tr�n 7.0 
select exam_management.student_id,  exam_management.subject_id, exam_management.mark
from exam_management
where exam_management.number_of_exam_taking = 1 
and exam_management.mark > 7.0
and exam_management.student_id = (select student.id 
from student 
where student.gender = 'Nam' 
and exam_management.student_id = student.id );
-- 14. Cho bi?t danh s�ch c�c sinh vi�n r?t �t nh?t 2 m�n ? l?n thi 1 (r?t m�n l� ?i?m thi c?a m�n kh�ng qu� 4 ?i?m)
select exam_management.student_id,  count(exam_management.subject_id) as numberoffails
from exam_management
where exam_management.number_of_exam_taking = 1 
and exam_management.mark <= 4.0
group by  exam_management.student_id
having count(exam_management.subject_id)>=2;


-- 15. Cho bi?t danh s�ch nh?ng khoa c� nhi?u h?n 2 sinh vi�n nam
select student.faculty_id from student
where student.gender = 'Nam' 
group by student.faculty_id
having count(student.gender)>2;

-- 16. Cho bi?t nh?ng khoa c� 2 sinh vi�n ??t h?c b?ng t? 200000 ??n 300000

select student.faculty_id from student
where (select student.faculty_id from student
where student.scholarship >= 200000 and   student.scholarship <= 300000
group by student.faculty_id
having count(student.faculty_id) = 2 ) = student.faculty_id;
-- 17. Cho bi?t sinh vi�n n�o c� h?c b?ng cao nh?t

select student.id from student
where(select MAX(student.scholarship) from student) = student.scholarship;
------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh vi�n c� n?i sinh ? H� N?i v� sinh v�o th�ng 02
select * from student 
where student.hometown = 'H� N?i' and (extract(month from student.birthday)) = 02;

-- 2. Sinh vi�n c� tu?i l?n h?n 20
select * from student
where (to_date('20220607', 'YYYYMMDD')- student.birthday) > 20;

-- 3. Sinh vi�n sinh v�o m�a xu�n n?m 1990

select * from student
where ( extract(month from student.birthday) = 01 
or extract(month from student.birthday) = 02 
or extract(month from student.birthday) = 03)
and extract(year from student.birthday) = 1990;


-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh s�ch c�c sinh vi�n c?a khoa ANH V?N v� khoa V?T L�

    select student.id, student.name, faculty.id as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where faculty.name = 'Anh - V?n' or faculty.name = 'V?t l�';

-- 2. Nh?ng sinh vi�n nam c?a khoa ANH V?N v� khoa TIN H?C
    select student.id, student.name, faculty.id as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where (faculty.name = 'Tin h?c' or faculty.name = 'Anh - V?n') and student.gender = 'Nam';

-- 3. Cho bi?t sinh vi�n n�o c� ?i?m thi l?n 1 m�n c? s? d? li?u cao nh?t
select student.id, student.name,exam_management.number_of_exam_taking, exam_management.mark  from exam_management
join student
on student.id = exam_management.student_id
join subject
on subject.id = exam_management.subject_id
where exam_management.number_of_exam_taking = 1 
and exam_management.mark = (select max(exam_management.mark) from exam_management
where  exam_management.subject_id = (select subject.id from subject where subject.name = 'C? s? d? li?u'));

-- 4. Cho bi?t sinh vi�n khoa anh v?n c� tu?i l?n nh?t.
select student.id, student.name, student.birthday as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where  student.birthday = (select min(student.birthday) from student
    where  student.faculty_id = (select faculty.id from faculty where faculty.name ='Anh - V?n'));


-- 5. Cho bi?t khoa n�o c� ?�ng sinh vi�n nh?t
   select count(student.id) as num, faculty.name  from faculty 
   join student
   on faculty.id = student.faculty_id
   where faculty.id = (select student.faculty_id from student group by student.faculty_id
   having count(student.id) = (select max(count(student.id))from student group by student.faculty_id))
   group by faculty.name 
  ;
   
   
-- 6. Cho bi?t khoa n�o c� ?�ng n? nh?t
select count(student.id) as num, faculty.name  from faculty 
   join student
   on faculty.id = student.faculty_id
   where faculty.id = (select student.faculty_id from student group by student.faculty_id
   having count(student.id) = (select max(count(student.id))from student where student.gender = 'N?' group by student.faculty_id))
   group by faculty.name 
  ;

-- 7. Cho bi?t nh?ng sinh vi�n ??t ?i?m cao nh?t trong t?ng m�n

select exam_management.student_id, student.name, subject.name from exam_management
join student
on student.id = exam_management.student_id
join subject
on subject.id = exam_management.subject_id
                    where exam_management.mark = (select max(exam_management.mark) from exam_management);

-- 8. Cho bi?t nh?ng khoa kh�ng c� sinh vi�n h?c
select faculty.name from student
right join faculty
on faculty.id = student.faculty_id
where student.faculty_id is null;
-- 9. Cho bi?t sinh vi�n ch?a thi m�n c? s? d? li?u
select * from student
where student.id not in (select exam_management.student_id from exam_management
join student
on student.id = exam_management.student_id
 join subject 
on subject.id = exam_management.subject_id
where  exists (select distinct exam_management.student_id from exam_management where subject.name = 'C? s? d? li?u'))
 ;


-- 10. Cho bi?t sinh vi�n n�o kh�ng thi l?n 1 m� c� d? thi l?n 2
