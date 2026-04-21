import "./project-preview.css"

function ProjectPreview(props) {
    const {project} = props
    
    return (
        <div className="project-preview">    
            <a href={project.external_link} target='_blank'>
                <img src={'src/assets/projects/' + project.logo}></img>
                {project.name}
            </a>
        </div>
    )
}

export default ProjectPreview;