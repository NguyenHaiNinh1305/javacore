/* I. CREATE TABLES */

-- faculty (Khoa trong tr??ng)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (Môn h?c)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- t?ng s? ti?t h?c
);

-- student (Sinh viên)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- gi?i tính
	birthday date not null,
	hometown nvarchar2(100) not null, -- quê quán
	scholarship number, -- h?c b?ng
	faculty_id number not null constraint faculty_id references faculty(id) -- mã khoa
);

-- exam management (B?ng ?i?m)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- s? l?n thi (thi trên 1 l?n ???c g?i là thi l?i) 
	mark number(4,2) not null -- ?i?m
);



/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, n'C? s? d? li?u', 45);
insert into subject values (2, n'Trí tu? nhân t?o', 45);
insert into subject values (3, n'Truy?n tin', 45);
insert into subject values (4, n'?? h?a', 60);
insert into subject values (5, n'V?n ph?m', 45);


-- faculty
insert into faculty values (1, n'Anh - V?n');
insert into faculty values (2, n'Tin h?c');
insert into faculty values (3, n'Tri?t h?c');
insert into faculty values (4, n'V?t lý');


-- student
insert into student values (1, n'Nguy?n Th? H?i', n'N?', to_date('19900223', 'YYYYMMDD'), 'Hà N?i', 130000, 2);
insert into student values (2, n'Tr?n V?n Chính', n'Nam', to_date('19921224', 'YYYYMMDD'), 'Bình ??nh', 150000, 4);
insert into student values (3, n'Lê Thu Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, n'Lê H?i Y?n', n'N?', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, n'Tr?n Anh Tu?n', n'Nam', to_date('19901220', 'YYYYMMDD'), 'Hà N?i', 180000, 1);
insert into student values (6, n'Tr?n Thanh Mai', n'N?', to_date('19910812', 'YYYYMMDD'), 'H?i Phòng', null, 3);
insert into student values (7, n'Tr?n Th? Thu Th?y', n'N?', to_date('19910102', 'YYYYMMDD'), 'H?i Phòng', 10000, 1);


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

-- 1. Li?t kê danh sách sinh viên s?p x?p theo th? t?:
--      a. id t?ng d?n
--      b. gi?i tính
--      c. ngày sinh T?NG D?N và h?c b?ng GI?M D?N

-- 1.a
Select * from student
order by student.id asc;

--1.b
Select * from student
order by student.gender asc;

--1.c
Select * from student
order by student.birthday ASC, student.scholarship DESC;

-- 2. Môn h?c có tên b?t ??u b?ng ch? 'T'

select * from subject
where subject.name like 'T%';

-- 3. Sinh viên có ch? cái cu?i cùng trong tên là 'i'
select * from student
where student.name like '%i';


-- 4. Nh?ng khoa có ký t? th? hai c?a tên khoa có ch?a ch? 'n'
select * from faculty
where faculty.name like '_n%';

-- 5. Sinh viên trong tên có t? 'Th?'
select * from student
where student.name like '%Th?%';


-- 6. Sinh viên có ký t? ??u tiên c?a tên n?m trong kho?ng t? 'a' ??n 'm', s?p x?p theo h? tên sinh viên
select * from student
where student.name like 'T%' 
order by student.name;

-- 7. Sinh viên có h?c b?ng l?n h?n 100000, s?p x?p theo mã khoa gi?m d?n
select * from student
where student.scholarship > 100000
order by student.faculty_id DESC;

-- 8. Sinh viên có h?c b?ng t? 150000 tr? lên và sinh ? Hà N?i
select * from student
where student.scholarship > 150000 and hometown = 'Hà N?i';

-- 9. Nh?ng sinh viên có ngày sinh t? ngày 01/01/1991 ??n ngày 05/06/1992
select * from student
where student.birthday between to_date('19910101', 'YYYYMMDD') and to_date('19920605', 'YYYYMMDD');


-- 10. Nh?ng sinh viên có h?c b?ng t? 80000 ??n 150000

select * from student
where 80000<= student.scholarship and student.scholarship <= 100000;

-- 11. Nh?ng môn h?c có s? ti?t l?n h?n 30 và nh? h?n 45

select * from subject
where 30 < subject.lesson_quantity and subject.lesson_quantity < 45;

-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho bi?t thông tin v? m?c h?c b?ng c?a các sinh viên, g?m: Mã sinh viên, Gi?i tính, Mã 
		-- khoa, M?c h?c b?ng. Trong ?ó, m?c h?c b?ng s? hi?n th? là “H?c b?ng cao” n?u giá tr? 
		-- c?a h?c b?ng l?n h?n 500,000 và ng??c l?i hi?n th? là “M?c trung bình”.
        select student.id, student.gender, student.faculty_id, student.scholarship,
        case when student.scholarship >500000 then  'high'
        else  'medium'
        end sholarlevel
        from student;
		
-- 2. Tính t?ng s? sinh viên c?a toàn tr??ng

select  count(*)  AS totalstundent from student;


-- 3. Tính t?ng s? sinh viên nam và t?ng s? sinh viên n?.

select student.gender, count(*) AS total from student
group by student.gender;

-- 4. Tính t?ng s? sinh viên t?ng khoa
select student.faculty_id, count(*) AS total from student
group by student.faculty_id;


-- 5. Tính t?ng s? sinh viên c?a t?ng môn h?c

select  exam_management.subject_id, count(exam_management.student_id) AS totalstudent from exam_management
group by exam_management.subject_id;

-- 6. Tính s? l??ng môn h?c mà sinh viên ?ã h?c
select  exam_management.student_id, count(exam_management.subject_id) AS total_learned_subject from exam_management
group by exam_management.student_id;
-- h?i l?i
-- 7. T?ng s? h?c b?ng c?a m?i khoa	
select student.faculty_id, count(student.scholarship) as total_scholarship from student
group by student.faculty_id;
-- 8. Cho bi?t h?c b?ng cao nh?t c?a m?i khoa
select student.faculty_id, max(student.scholarship) as max_scholarship from student
group by student.faculty_id;


-- 9. Cho bi?t t?ng s? sinh viên nam và t?ng s? sinh viên n? c?a m?i khoa
select student.gender,student.faculty_id, count(*) AS total from student
group by student.gender, student.faculty_id;

-- 10. Cho bi?t s? l??ng sinh viên theo t?ng ?? tu?i
select extract(year from student.birthday) as year,  count(student.id) AS total from student
group by extract(year from student.birthday);

-- 11. Cho bi?t nh?ng n?i nào có ít nh?t 2 sinh viên ?ang theo h?c t?i tr??ng

select student.hometown, count(student.id) AS numbers from student
group by student.hometown
having count(student.id)>=2 ;

-- 12. Cho bi?t nh?ng sinh viên thi l?i ít nh?t 2 l?n

select exam_management.student_id, count(exam_management.number_of_exam_taking) as total_reexam from exam_management
where exam_management.number_of_exam_taking = 2
group by exam_management.student_id
having count(exam_management.number_of_exam_taking)>=2;

-- 13. Cho bi?t nh?ng sinh viên nam có ?i?m trung bình l?n 1 trên 7.0 
select exam_management.student_id,  exam_management.subject_id, exam_management.mark
from exam_management
where exam_management.number_of_exam_taking = 1 
and exam_management.mark > 7.0
and exam_management.student_id = (select student.id 
from student 
where student.gender = 'Nam' 
and exam_management.student_id = student.id );
-- 14. Cho bi?t danh sách các sinh viên r?t ít nh?t 2 môn ? l?n thi 1 (r?t môn là ?i?m thi c?a môn không quá 4 ?i?m)
select exam_management.student_id,  count(exam_management.subject_id) as numberoffails
from exam_management
where exam_management.number_of_exam_taking = 1 
and exam_management.mark <= 4.0
group by  exam_management.student_id
having count(exam_management.subject_id)>=2;


-- 15. Cho bi?t danh sách nh?ng khoa có nhi?u h?n 2 sinh viên nam
select student.faculty_id from student
where student.gender = 'Nam' 
group by student.faculty_id
having count(student.gender)>2;

-- 16. Cho bi?t nh?ng khoa có 2 sinh viên ??t h?c b?ng t? 200000 ??n 300000

select student.faculty_id from student
where (select student.faculty_id from student
where student.scholarship >= 200000 and   student.scholarship <= 300000
group by student.faculty_id
having count(student.faculty_id) = 2 ) = student.faculty_id;
-- 17. Cho bi?t sinh viên nào có h?c b?ng cao nh?t

select student.id from student
where(select MAX(student.scholarship) from student) = student.scholarship;
------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh viên có n?i sinh ? Hà N?i và sinh vào tháng 02
select * from student 
where student.hometown = 'Hà N?i' and (extract(month from student.birthday)) = 02;

-- 2. Sinh viên có tu?i l?n h?n 20
select * from student
where (to_date('20220607', 'YYYYMMDD')- student.birthday) > 20;

-- 3. Sinh viên sinh vào mùa xuân n?m 1990

select * from student
where ( extract(month from student.birthday) = 01 
or extract(month from student.birthday) = 02 
or extract(month from student.birthday) = 03)
and extract(year from student.birthday) = 1990;


-------------------------------------------------------------------


/********* D. JOIN QUERY *********/

-- 1. Danh sách các sinh viên c?a khoa ANH V?N và khoa V?T LÝ

    select student.id, student.name, faculty.id as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where faculty.name = 'Anh - V?n' or faculty.name = 'V?t lý';

-- 2. Nh?ng sinh viên nam c?a khoa ANH V?N và khoa TIN H?C
    select student.id, student.name, faculty.id as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where (faculty.name = 'Tin h?c' or faculty.name = 'Anh - V?n') and student.gender = 'Nam';

-- 3. Cho bi?t sinh viên nào có ?i?m thi l?n 1 môn c? s? d? li?u cao nh?t
select student.id, student.name,exam_management.number_of_exam_taking, exam_management.mark  from exam_management
join student
on student.id = exam_management.student_id
join subject
on subject.id = exam_management.subject_id
where exam_management.number_of_exam_taking = 1 
and exam_management.mark = (select max(exam_management.mark) from exam_management
where  exam_management.subject_id = (select subject.id from subject where subject.name = 'C? s? d? li?u'));

-- 4. Cho bi?t sinh viên khoa anh v?n có tu?i l?n nh?t.
select student.id, student.name, student.birthday as faculy_id, faculty.name as faculty_name from student 
    join faculty
    on student.faculty_id = faculty.id
    where  student.birthday = (select min(student.birthday) from student
    where  student.faculty_id = (select faculty.id from faculty where faculty.name ='Anh - V?n'));


-- 5. Cho bi?t khoa nào có ?ông sinh viên nh?t
   select count(student.id) as num, faculty.name  from faculty 
   join student
   on faculty.id = student.faculty_id
   where faculty.id = (select student.faculty_id from student group by student.faculty_id
   having count(student.id) = (select max(count(student.id))from student group by student.faculty_id))
   group by faculty.name 
  ;
   
   
-- 6. Cho bi?t khoa nào có ?ông n? nh?t
select count(student.id) as num, faculty.name  from faculty 
   join student
   on faculty.id = student.faculty_id
   where faculty.id = (select student.faculty_id from student group by student.faculty_id
   having count(student.id) = (select max(count(student.id))from student where student.gender = 'N?' group by student.faculty_id))
   group by faculty.name 
  ;

-- 7. Cho bi?t nh?ng sinh viên ??t ?i?m cao nh?t trong t?ng môn

select exam_management.student_id, student.name, subject.name from exam_management
join student
on student.id = exam_management.student_id
join subject
on subject.id = exam_management.subject_id
                    where exam_management.mark = (select max(exam_management.mark) from exam_management);

-- 8. Cho bi?t nh?ng khoa không có sinh viên h?c
select faculty.name from student
right join faculty
on faculty.id = student.faculty_id
where student.faculty_id is null;
-- 9. Cho bi?t sinh viên ch?a thi môn c? s? d? li?u
select * from student
where student.id not in (select exam_management.student_id from exam_management
join student
on student.id = exam_management.student_id
 join subject 
on subject.id = exam_management.subject_id
where  exists (select distinct exam_management.student_id from exam_management where subject.name = 'C? s? d? li?u'))
 ;


-- 10. Cho bi?t sinh viên nào không thi l?n 1 mà có d? thi l?n 2
