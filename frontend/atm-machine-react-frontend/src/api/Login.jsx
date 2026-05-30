import { useState } from "react";
import api from "../api/atmApi";

function Login() {

  const [accountNumber, setAccountNumber] = useState("");
  const [pin, setPin] = useState("");
  const [message, setMessage] = useState("");

  const handleLogin = async () => {

    try {

      const response = await api.post("/login", {
        accountNumber,
        pin
      });

      setMessage(response.data.message);

    } catch (error) {

      setMessage("Login Failed");

    }

  };

  return (
    <div>
      <h1>ATM Login</h1>

      <input
        placeholder="Account Number"
        value={accountNumber}
        onChange={(e) => setAccountNumber(e.target.value)}
      />

      <br /><br />

      <input
        placeholder="PIN"
        type="password"
        value={pin}
        onChange={(e) => setPin(e.target.value)}
      />

      <br /><br />

      <button onClick={handleLogin}>
        Login
      </button>

      <p>{message}</p>
    </div>
  );
}

export default Login;