import React, { useState, useEffect } from "react";
import axios from "axios";
import "./StudentManager.css";

function StudentManager() {

  // ✅ EMPTY initially (data comes from backend)
  const [students, setStudents] = useState([]);

  const [newStudent, setNewStudent] = useState({
    name: "",
    course: ""
  });

  // ✅ FETCH DATA FROM BACKEND
  const fetchStudents = () => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data))
      .catch(err => console.log(err));
  };

  // ✅ LOAD DATA ON PAGE LOAD
  useEffect(() => {
    fetchStudents();
  }, []);

  // ✅ HANDLE INPUT CHANGE
  const handleChange = (e) => {
    const { name, value } = e.target;

    setNewStudent({
      ...newStudent,
      [name]: value
    });
  };

  // ✅ ADD STUDENT (BACKEND CALL)
  const addStudent = () => {

    if (!newStudent.name || !newStudent.course) {
      alert("Please fill all fields");
      return;
    }

    axios.post("http://localhost:8080/students", newStudent)
      .then(() => {
        fetchStudents(); // refresh data
        setNewStudent({ name: "", course: "" });
      })
      .catch(err => console.log(err));
  };

  // ✅ DELETE STUDENT (BACKEND CALL)
  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => fetchStudents())
      .catch(err => console.log(err));
  };

  return (
    <div className="container">

      <h2>Student Manager</h2>

      <div className="form">

        {/* ❌ REMOVE ID INPUT (AUTO GENERATED IN BACKEND) */}

        <input
          type="text"
          name="name"
          placeholder="Student Name"
          value={newStudent.name}
          onChange={handleChange}
        />

        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleChange}
        />

        <button onClick={addStudent}>Add Student</button>

      </div>

      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>

          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>

          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="delete"
                    onClick={() => deleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>

        </table>
      )}

    </div>
  );
}

export default StudentManager;