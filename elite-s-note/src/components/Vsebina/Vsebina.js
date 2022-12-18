import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../../services/api";
import SkupinaTable from "./SkupinaTable";

const Vsebina = () => {
    const [skupina, setSkupina] = useState([]);
    useEffect(() => {
        const pridobiSkupine = () => {
            api.get("/skupina").then((result) => {
                setSkupina(result.data);
                console.log(result);
            });
        }
        pridobiSkupine();
    }, []);
    return (
        <>
            <h1>Skupina</h1>
            <Link to="/skupina/dodaj"><Button variant="contained">Dodaj skupino</Button></Link>
            <SkupinaTable skupina={skupina} />
        </>
    );
}
export default Vsebina;