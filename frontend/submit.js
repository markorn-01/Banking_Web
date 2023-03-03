async function submit() {
    const firstName = document.getElementById('first_name').value;
    const lastName = document.getElementById('last_name').value;
    const address = document.getElementById('address').value;
    const password = document.getElementById('password').value;
    const email = document.getElementById('email').value;
    const res = await fetch("http://localhost:8080/process_register", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
		method: "POST",
		body: JSON.stringify({
			firstName,
			lastName,
            address,
            password,
			email,
		}),
	})
	const data = await res.json()
	console.log(data)
    if (data.success) {
        window.location.href = "http://localhost:5500/success";
    }
}

