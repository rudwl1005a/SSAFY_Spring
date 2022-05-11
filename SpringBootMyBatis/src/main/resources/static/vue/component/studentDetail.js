export default {
    template:
    `
    <table>
        <tbody>
            <tr><td>StudentNm</td><td><input type="text" v-model="student.studentNm" placeholder="name"></td></tr>
            <tr><td>Email</td><td><input type="text" v-model="student.email" placeholder="email"></td></tr>
            <tr><td>Phone</td><td><input type="text" v-model="student.phone" placeholder="phone"></td></tr>
        </tbody>
    </table>
    `,
    props: ['student'],
}