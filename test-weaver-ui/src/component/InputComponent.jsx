import React, { Component } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

class InputComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { 'code' : '',
                        'framework' : '',
                        'generatedTestCases' : '' }

        this.handleCodeInputChange = this.handleCodeInputChange.bind(this);
        this.handleFrameworkInputChange = this.handleFrameworkInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleCodeInputChange(event) {
        this.setState ({ code : event.target.value });
    }

    handleFrameworkInputChange(event) {
        this.setState ({ framework : event.target.value });
    }

    async handleSubmit(event) {
        event.preventDefault();
        const userData = {
            code: this.state.code,
            framework: this.state.framework
        }

        try {
            const response = await axios.post("http://localhost:8080/generate-test-cases", userData);
            this.setState({ generatedTestCases : response.data });
        } catch(error) {
            console.log("Error:", error);
        }
    }
    
    render() {
        return (
            <div className="d-flex flex-column align-items-center justify-content-center vh-100">
                <header className="my-3 text-center">
                    <h1>Test Weaver</h1>
                    <h5>Making you smarter every day</h5>
                </header>
                <div className="card p-3 mt-2 mb-2 w-75 shadow">
                    <div className="card-body">
                        <div className="d-flex flex-row">
                            <div className="col-6">
                                    <div className="card-body">
                                            <div className="form-group mb-3">
                                                <label>Code:</label>
                                                <textarea className="form-control" rows="14" value={this.state.code} onChange={this.handleCodeInputChange} />
                                            </div>
                                    </div>
                            </div>
                            <div className="col-6">
                                <div className="card-body">
                                    <label>Output:</label>
                                    <textarea className="form-control" rows="14" value={this.state.generatedTestCases} readOnly/>
                                </div>
                            </div>
                        </div>
                        <div className="card-body" style={{width:"100%"}}>
                            <div className="form-group mb-3 text-center">
                                <label>Testing Framework:</label>
                                <input type="text" className="form-control" value={this.state.framework} onChange={this.handleFrameworkInputChange} />
                            </div>
                            <button type="submit" className="btn btn-primary" onClick={this.handleSubmit}>Submit</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default InputComponent;