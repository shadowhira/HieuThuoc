export class AuthConstant {
  // new auth
  public static readonly ACCESS_TOKEN_KEY = "access_token_front";
  public static readonly REFRESH_TOKEN_KEY = "refresh_token";
  public static readonly CLIENT_CREDENTIALS_KEY = "client_credentials_token";
  public static readonly TOKEN_TYPE_KEY = "Bearer ";
  public static readonly TOKEN_EXPIRE = 1; // one day

  public static readonly ROLE_ADMIN = 1;
  public static readonly ROLE_MANAGER = 2;
  public static readonly ROLE_PHARMACIST = 3;
  public static readonly ROLE_CASHIER = 4;
  public static readonly ROLE_KHACHHANG = 5;
}
