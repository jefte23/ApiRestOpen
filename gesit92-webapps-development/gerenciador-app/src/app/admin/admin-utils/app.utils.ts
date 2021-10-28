import * as moment from "moment";

export class AppUtils {
    
  public static readonly FORMATO_HORA = "HH:mm";
  public static readonly FORMATO_DATA = "DD/MM/YYYY";
  public static readonly FORMATO_DATA_HORA = 'YYYY-MM-DD HH:mm:ss';

  public static geFormatar(data, formato: string) {
    return moment(data).format(formato);
  }

  public static geFormatartDataHora(data) {
    return moment(data).format(this.FORMATO_DATA_HORA);
  }
}
