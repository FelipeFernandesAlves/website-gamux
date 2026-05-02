/**
 * Um evento organizado pela Gamux.
 */
class GamuxEvent {
    name: string;
    description: string;
    startDate: Date;
    endDate: Date;
    hours: string;
    location: string;
    registerLink?: string | null;
    locationLink?: string | null;
    banner: string;
    privacy: "public" | "private" = "public";


    /**
     * Cria uma instância de GamuxEvent.
     * @param name - O nome do evento.
     * @param description - Uma descrição do evento. 
     * @param startDate - A data de início do evento.
     * @param endDate - A data de fim do evento.
     * @param hours - O horário do evento.
     * @param location - O local do evento.
     * @param registerLink - Um link para o registro no evento.
     * @param banner - O url do banner do evento.
     * @param privacy - A privacidade do evento.
     * @param locationLink - Um link para o local do evento (ex: Google Maps).
     */
    constructor(name: string, description: string, startDate: Date, endDate: Date, hours: string, location: string, banner: string, privacy: "public" | "private" = "public", locationLink: string | null = null, registerLink: string | null = null) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hours = hours;
        this.location = location;
        this.registerLink = registerLink;
        this.locationLink = locationLink;
        this.banner = banner;
        this.privacy = privacy;
    }
}

export default GamuxEvent;