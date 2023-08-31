const base = {
    get() {
                return {
            url : "http://localhost:8080/springbootu72sl/",
            name: "springbootu72sl",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootu72sl/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "Pure心灵治愈交流平台"
        } 
    }
}
export default base
