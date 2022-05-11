export default {
    template:
    `
    <table>
        <thead>
            <tr><td>StudentId</td><td>StudentNm</td><td>Email</td><td>Phone</td></tr>
        </thead>
        <tbody>
            <tr style="cursor: pointer" v-for="(student, index) in studentList" :key="index" @click="detailStudent(student.studentId)">
                <td>{{ student.studentId }}</td>
                <td>{{ student.studentNm }}</td>
                <td>{{ student.email }}</td>
                <td>{{ student.phone }}</td>
            </tr>
        </tbody>
    </table>   
    `,
    props: ['studentList'],
    methods: {
        async detailStudent(studentId) {
            this.$emit('call-parent-detail', studentId);
        },
    }
}